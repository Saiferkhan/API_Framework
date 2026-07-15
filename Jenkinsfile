pipeline {
    agent any

    tools {
        jdk 'JDK-21.0.10'
        maven 'Maven-3.9.12'
    }

    stages {

        stage('Checkout API Framework') {
            steps {
                dir('API_Framework') {
                    git branch: 'main',
                        url: 'https://github.com/Saiferkhan/API_Framework'
                }
            }
        }

        stage('Checkout Developers Code') {
            steps {
                dir('DevelopersCode') {
                    git branch: 'main',
                        url: 'https://github.com/Saiferkhan/DevelopersCode'
                }
            }
        }

        stage('Build and Test') {
            steps {
                dir('API_Framework') {
                    bat 'mvn clean test'
                }
            }
        }
    }

    post {
        always {
            dir('API_Framework') {
                bat 'dir target\\surefire-reports'
                junit allowEmptyResults: true,
                      testResults: '**/target/surefire-reports/*.xml'
            }
        }
    }
}
