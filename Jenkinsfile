// pipeline {
//     agent any
//     tools {
//         maven 'Maven 3.8.4'
//     }
//     stages {

//         stage('Get the Repo')
//         {
//             steps{
//                 bat 'git clone "https://github.com/anirudhk999/java_sorting_algorithms"'
//             }
//         }
//         stage('Build') {
//             steps {
//                 bat 'mvn -B -DskipTests clean package'
//             }
//         }
//         stage('Run Unit Tests') {
//             steps 
//             {
//                 // Compile the Java code and run the unit tests on Windows
//                 bat 'mvn test'

//             }
//         }

//         post
//         {
//             always{
//                 cleanWs()
//             }
//         }
        

//     }
// }

pipeline {
    agent any
 
    tools {
        maven 'Maven 3.8.4'
    }
 
    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/anirudhk999/final_pipeline_job'
            }
        }
 
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
 
        stage('Run App.java') {
            steps {
                sh 'java -cp target/classes com.yourpackage.App'
            }
        }
 
        stage('Unit Tests') {
            steps {
                sh 'mvn test'
            }
        }
 
        // stage('SonarQube Analysis') {
        //     steps {
        //         withSonarQubeEnv('SonarQube') {
        //             sh 'mvn sonar:sonar'
        //         }
        //     }
        // }
    }
 
    post {
        always
        {
            cleanWs()
        }
        // failure 
        // {
        //     mail to: 'developers@yourcompany.com',
        //          subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
        //          body: "Something is wrong with ${env.BUILD_URL}"
        // }
    }
}
