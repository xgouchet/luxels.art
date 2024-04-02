
## Gradle Project

### Local checks

```shell
./gradlew check
```

### Build Jar

```shell
./gradlew shadowJar
```

## `Platform.sh`

### Setup

```shell
brew install platformsh/tap/platformsh-cli
```

### Configuration

The `Platform.sh` framework uses the following files to configure the app: 

- [.platform.app.yaml](.platform.app.yaml): describes the global setup of the project.
- [routes.yaml](.platform/routes.yaml): describes the way to handle routes
- [project.yaml](.platform/local/project.yaml): configures the local setup to link the project with the remote.

You can use the following to setup the local configuration:

```shell
platform project:set-remote $PROJECT_ID
```

### Build

You can build your branch locally using the following script: 

```shell
./gradlew shadowJar
```

### Publish

Once the project is configured, the git repo should track a `platform` remote repository. 
Publishing on the `platform/main` branch automatically updates and build the app on the server.

### Troubleshooting


#### Build logs

You can list activities (Build, …) with the following:

```shell
platform activity:list -e main
```
This will output a table of recent activities, the first column giving you the ID. 

You can then show the activity's logs with:

```shell
platform activity:log $ACTIVITY_ID
```

#### Runtime logs

- To read the logs written at runtime by the app (via std output)

```shell
platform log -e main app
```

- To read the access logs of each HTTP request

```shell
platform log -e main access
```
- To read the error logs from the server

```shell
platform log -e main error
```
#### Runtime environment

You can check the runtime environment using 

```shell
platform environment:info --environment main
```

### Backups

You can list the mounted file storages using the following command: 

```shell
platform mounts
```

To download a backup of the main storage, you can use the following script:

```shell
current_date=$(date '+%Y_%m_%d')
mkdir -p "backup_${current_date}"
platform mount:download --mount storage --environment main --target "./backup_${current_date}"
```
