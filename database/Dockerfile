FROM postgres:14.7-alpine
ENV POSTGRES_PASSWORD=test123
ENV POSTGRES_USER=richard
ENV POSTGRES_DB=users
COPY schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432:5432
