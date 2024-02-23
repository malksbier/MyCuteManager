https://github.com/jonashackt/spring-boot-vuejs

compile:
root: mvn clean install
run:
root: mvn --projects backend spring-boot:run

test Frontend:
root/Frontend: npm run serve