pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    triggers {
        githubPush()
    }

    environment {
        DOCKER_IMAGE = "your_dockerhub_username/scientific-calculator"
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Unit Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE:${BUILD_NUMBER} .'
                sh 'docker tag $DOCKER_IMAGE:${BUILD_NUMBER} $DOCKER_IMAGE:latest'
            }
        }

        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub-creds',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh 'echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin'
                }
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push $DOCKER_IMAGE:${BUILD_NUMBER}'
                sh 'docker push $DOCKER_IMAGE:latest'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker stop scientific-calculator || true
                docker rm scientific-calculator || true
                docker run -d -p 8081:8080 --name scientific-calculator $DOCKER_IMAGE:latest
                '''
            }
        }
    }

    post {
        success {
            emailext (
                subject: "BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build successful. Docker image pushed and deployed.",
                to: "sharma.piyush4019@gmail.com"
            )
        }

        failure {
            emailext (
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "Build failed. Check Jenkins.",
                to: "sharma.piyush4019@gmail.com"
            )
        }
    }
}