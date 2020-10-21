#ManishChallengeProject

Android app to retrieve a list of commits using the Github API 


## Getting Started

You can clone or download this project to your local machine. 

### Prerequisites

Intermediate Android Experience
Little or no experience with [Retrofit] (http://square.github.io/retrofit/) Library
[GitHub API  ] (https://api.github.com/username)



### Dependencies
To use Retrofit, added this library in your dependencies. You also need a converter used for JSON format : Gson.
Dagger for dependency injection, RXJava for observation or thread

#MainActivity - this is main activity, entry point for application

#GitHubFragment - main fragment class, responsible for view rendering. Attached with view model

#GitHubViewModel - viewmodel class, responsible for data update. provide data change notification to fragment. Attached with repository

#GitHubRepository - repository class, responsible to make api call and provide data to view model




