# プロセスの削除   grep -v "grep"は、grepコマンドのプロセスを対象外にするためのもの
PID=$(/bin/ps -fu $USER | grep "java -jar target/onemessageapi-0.0.1-SNAPSHOT.jar" | grep -v "grep" | awk '{print $2}')
echo $PID
if [ -n "$PID" ]; then
  kill $PID
fi

mvn package spring-boot:repackage -Dmaven.test.skip

nohup java -jar target/onemessageapi-0.0.1-SNAPSHOT.jar &
