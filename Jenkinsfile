pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    triggers {
        githubPush()
        pollSCM('H/2 * * * *')
    }

    environment {
        DOCKER_IMAGE = "p1yush123/scientific-calculator"
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

        stage('Deploy with Ansible') {
            steps {
                sh 'ansible-playbook ansible/deploy.yml'
            }
        }

    }   // ← Only ONE closing brace for stages

    post {

        success {
            mail(
                to: 'sharma.piyush4019@gmail.com',
                subject: "BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
    Build Successful!

    Job Name: ${env.JOB_NAME}
    Build Number: ${env.BUILD_NUMBER}

    Docker Image: ${env.DOCKER_IMAGE}:latest

    Check build details:
    ${env.BUILD_URL}
    """
            )
        }

        failure {
            mail(
                to: 'sharma.piyush4019@gmail.com',
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: """
    Build Failed!

    Job Name: ${env.JOB_NAME}
    Build Number: ${env.BUILD_NUMBER}

    Check Jenkins Console:
    ${env.BUILD_URL}
    """
            )
        }
    }
}