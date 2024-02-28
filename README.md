# Proyecto de Ejemplo con Spring Boot: Inyección de Dependencias desde Base de Datos y JSON

¡Hola! En este proyecto, me gustaría explicarte cómo implementamos la inyección de dependencias en una aplicación Spring Boot, utilizando tanto una base de datos como un archivo JSON como fuentes de datos.

<h3>1. Configuración del Proyecto</h3>

Primero, asegurémonos de tener configurado nuestro proyecto de Spring Boot correctamente. Utilicé Spring Initializr para generar un proyecto básico con las dependencias necesarias.

<h3>2. Definición de las Dependencias</h3>

En nuestro archivo pom.xml (si estamos utilizando Maven) o build.gradle (si estamos utilizando Gradle), agregamos las dependencias necesarias para la persistencia de datos y para trabajar con JSON:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
<dependency>
  <groupId>com.felipe.springboot.di.app</groupId>
  <artifactId>springboot-di</artifactId>
</dependency>
```

<h3>3. Creación de la Entidad y Repositorio</h3>

Definimos nuestra entidad JPA y su repositorio correspondiente:

```xml
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    // Getters y Setters
}

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
```

<h3>4. Inyección de Dependencias desde la Base de Datos</h3>

En nuestros componentes de servicio, podemos inyectar el repositorio y trabajar con la base de datos:

```xml
  @Service
  public class UsuarioService {
      @Autowired
      private UsuarioRepository usuarioRepository;
      // Métodos para acceder a la base de datos
  }
```
<h3>5. Lectura de Datos desde un Archivo JSON</h3>

Para leer datos desde un archivo JSON, podemos usar la librería Jackson:

```xml
  @Component
  public class JsonReader {
      private ObjectMapper objectMapper = new ObjectMapper();
  
      public List<Usuario> readUsuariosFromJson(String jsonFilePath) throws IOException {
          File file = new File(jsonFilePath);
          return objectMapper.readValue(file, new TypeReference<List<Usuario>>() {});
      }
  }

```

<h3>6. Utilizando los Datos</h3>

Finalmente, podemos utilizar los datos obtenidos tanto de la base de datos como del archivo JSON en nuestra lógica de negocio.

¡Y eso es todo! Hemos explicado cómo configurar la inyección de dependencias en Spring Boot utilizando tanto una base de datos como un archivo JSON como fuentes de datos.
