Run API publicatios
spring-boot:run -Dspring-boot.run.fork=false

Compile API publicatios
install -DskipTests -T 4

## Requisitos
1. jdk v23
2. maven
3. spring-boot v3.4.1

## Endpoints disponibles
### Back-end
    get("/api/publication") Descarga todas las publicaciones
    get("/api/publication/search?s={s}") Realiza la búsqueda dinámica de las publicaciones