# Evaluacion (TaskMaster)

Aplicación Android desarrollada para la Evaluación Final Unidad I —
Programación Android (Santo Tomás). El proyecto de Android Studio se
llama **Evaluacion** (paquete `com.example.evaluacion`); la app que
contiene es **TaskMaster**.

## Descripción

TaskMaster permite a los usuarios gestionar sus tareas diarias: crearlas,
clasificarlas por categoría y prioridad, calificar su importancia y
marcarlas como completadas.

## Pantallas

1. **WelcomeActivity** (`activity_welcome.xml` — ConstraintLayout)
   Pantalla de bienvenida / Activity de inicio. Muestra el logo, un
   ProgressBar de carga y navega automáticamente (o mediante botón) al
   Login. Implementa y registra en Logcat todo el ciclo de vida
   (onCreate, onStart, onResume, onPause, onStop, onDestroy).

2. **LoginActivity** (`activity_login.xml` — ConstraintLayout)
   Inicio de sesión simple con validación de campos.

3. **MenuActivity** (`activity_menu.xml` — LinearLayout + CardView)
   Menú principal con accesos a la lista de tareas y a agregar tarea.

4. **TaskListActivity** (`activity_task_list.xml` — LinearLayout)
   Lista las tareas mediante un `RecyclerView` cuyos ítems son tarjetas
   `CardView` (`item_task.xml`), reutilizando el módulo `TaskAdapter`.

5. **AddTaskActivity** (`activity_add_task.xml` — ScrollView + TableLayout)
   Formulario para crear una tarea nueva. Incluye:
   - `TableLayout` para alinear etiquetas y campos (Título, Descripción, Categoría)
   - `Spinner` para la categoría
   - `RadioGroup` / `RadioButton` para la prioridad
   - `RatingBar` para la importancia
   - `CheckBox` para marcar como completada
   - `ImageView` de vista previa
   - `ProgressBar` mientras se guarda

## Estructura del código (módulos reutilizables)

```
app/src/main/java/com/example/evaluacion/
├── WelcomeActivity.java
├── LoginActivity.java
├── MenuActivity.java
├── TaskListActivity.java
├── AddTaskActivity.java
├── model/
│   └── Task.java          # Modelo de datos de una tarea
└── adapter/
    └── TaskAdapter.java   # Adaptador reutilizable para el RecyclerView
```

## Configuración técnica

Gradle con Kotlin DSL y catálogo de versiones (`gradle/libs.versions.toml`),
`compileSdk`/`targetSdk` 37, `minSdk` 30 — igual criterio que el proyecto
de referencia AppBodega2026.

## Cómo abrir el proyecto

1. Abrir Android Studio → **Open** → seleccionar la carpeta `Evaluacion`.
2. Esperar a que Gradle sincronice (el wrapper ya está incluido).
3. Ejecutar en un emulador o dispositivo (minSdk 30).

## Control de versiones (GIT)

Este proyecto ya incluye un repositorio Git local inicializado con un
historial de commits. Para compartirlo según lo solicitado en la pauta:

```bash
# 1. Crear un repositorio vacío en GitHub/GitLab (sin README, sin licencia)
# 2. Conectar el repositorio local con el remoto:
git remote add origin <URL_DE_TU_REPOSITORIO>
git branch -M main
git push -u origin main

# 3. Copiar el enlace del repositorio y compartirlo en el Aula Virtual
#    dentro del plazo acordado.
```

Para nuevas versiones a medida que avances:

```bash
git add .
git commit -m "Descripción del cambio"
git push
```
