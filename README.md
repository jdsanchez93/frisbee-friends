# frisbee-friends

## Just some notes for now ...

Build image:
```
docker build -t frisbee-friends:0.0.1-beta .
```

Run container (assumes mysql running in docker compose):
```
docker run -it --rm -p 3001:8080 --name frisbee-friends --env spring__datasource__url="jdbc:mysql://db:3306/frisbee_friends" --network=frisbee-friends_default frisbee-friends:0.0.1-beta
```