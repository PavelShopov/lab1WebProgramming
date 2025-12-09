FROM ubuntu:latest
LABEL authors="pilot"

ENTRYPOINT ["top", "-b"]