BUILD_DIR="build"
TOMCAT_DIR="/home/ermite/Documents/apache-tomcat-10.1.28"
PROJECT_NAME="ETU003251"

mkdir -p "src/main/webapp/WEB-INF/classes"

find src/main/java -name *.java > "test.txt"
cat test.txt |xargs javac -cp "lib/*" -d "src/main/webapp/WEB-INF/classes"
#ou aussi 
# xargs -a test.txt javac -cp "lib/*" -d "$BUILD_DIR/WEB-INF/classes"

rm test.txt

mkdir $BUILD_DIR

cp -r src/main/webapp/* $BUILD_DIR
cp -r "src/main/webapp/WEB-INF/." "$BUILD_DIR/WEB-INF/"

cp -r lib $BUILD_DIR/WEB-INF/

jar cvf "$PROJECT_NAME.war" -C  "$BUILD_DIR" .

rm -rf build/

rm -rf src/main/webapp/WEB-INF/classes


cp "$PROJECT_NAME.war" "$TOMCAT_DIR/webapps"

cd "$TOMCAT_DIR/bin/"
./shutdown.sh
# ./startup.sh



