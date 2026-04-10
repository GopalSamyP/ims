pipeline {
    agent any

    tools {
        maven 'Maven'   // we will configure this in Jenkins
    }

    stages {

        stage('Clone') {
            steps {
                git 'https://github.com/GopalSamyP/ims.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t springboot-app .'
            }
        }

        stage('Deploy') {
            steps {
                sh '''
                docker-compose down
                docker-compose up -d --build
                '''
            }
        }
    }
}