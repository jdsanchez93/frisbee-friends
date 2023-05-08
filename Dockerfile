FROM node:18-alpine as clientbuild
ENV NODE_ENV=production
WORKDIR /app
COPY ["./frisbee-friends-client/package.json", "./frisbee-friends-client/package-lock.json*", "./"]
RUN npm install --production
COPY ./frisbee-friends-client .
RUN npm run build

FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /workspace/app

COPY ./frisbee-friends-service /workspace/app
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean build
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*-SNAPSHOT.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.jd_sanchez.frisbeefriendsservice.FrisbeeFriendsServiceApplication"]