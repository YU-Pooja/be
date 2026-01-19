# Fullstack Backend 1801

A Spring Boot application for backend services.

## Local Development

1. Ensure you have Java 17 and Maven installed.
2. Set up a MySQL database.
3. Update `application.properties` with your database credentials.
4. Run `mvn spring-boot:run` to start the application.

## Deployment on Render

1. Push this code to a Git repository (GitHub, GitLab, or Bitbucket).
2. Sign up/login to [Render](https://render.com).
3. Create a new Web Service.
4. Connect your Git repository.
5. Configure the service:
   - **Environment**: Java
   - **Build Command**: `mvn clean install -DskipTests`
   - **Start Command**: `java -jar target/fulllstack-backend1801-0.0.1-SNAPSHOT.jar`
6. Add environment variables:
   - `DATABASE_URL`: Your database connection string (e.g., `jdbc:mysql://host:port/db?user=username&password=password` or just the Render-provided `mysql://...` URL)
   - `PORT`: Will be set automatically by Render
7. If using Render's managed database, create a MySQL database on Render and copy the connection details.

## API Endpoints

- `GET /users` - Get all users
- `GET /users/{id}` - Get user by ID
- `POST /users` - Create new user
- `PUT /users/{id}` - Update user
- `DELETE /users/{id}` - Delete user