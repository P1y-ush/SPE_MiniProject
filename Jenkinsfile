pipeline {
    agent any

    tools {
        maven 'Maven'
    }

    // Webhook trigger (Remove pollSCM)
    triggers {
        githubPush()
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
    }

    post {

        success {
            archiveArtifacts artifacts: 'target/*.jar', fingerprint: true

            emailext (
                subject: "BUILD SUCCESS: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "The build completed successfully.\n\nCheck Jenkins for details.",
                to: "piyushnnl1233@gmail.com"
            )
        }

        failure {
            emailext (
                subject: "BUILD FAILED: ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                body: "The build has failed.\n\nCheck Jenkins immediately.",
                to: "piyushnnl1233@gmail.com"
            )
        }
    }
}