# プロセスの削除
PID=$(/bin/ps -fu $USER | grep "java -jar target/onemessageapi-0.0.1-SNAPSHOT.jar" | grep -v "grep" | awk '{print $2}')

if [ -n "$PID" ]; then
  kill $PID
fi

mvn package spring-boot:repackage

nohup java -jar target/onemessageapi-0.0.1-SNAPSHOT.jar &
