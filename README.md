# Фреймворк Spring

## Урок 1. Системы сборки Maven и Gradle для разработки Java приложений

Создать проект с использованием Maven или Gradle, добавить в него несколько зависимостей и написать код, использующий эти зависимости.
Пример решения:
1. Создайте новый Maven или Gradle проект, следуя инструкциям из блока 1 или блока 2.
2. Добавьте зависимости org.apache.commons:commons-lang3:3.12.0 и com.google.code.gson:gson:2.8.6.
3. Создайте класс Person с полями firstName, lastName и age.
4. Используйте библиотеку commons-lang3 для генерации методов toString, equals и hashCode.
5. Используйте библиотеку gson для сериализации и десериализации объектов класса Person в формат JSON. [Решение](lesson_1/src/main/java/ru/gb/)

## Урок 2. Основы Spring. Spring Boot

Добавить в простое CRUD веб-приложение, которое было разработано на семинаре функцию удаления данных о пользователе:
1) В класс UserRepository добавить метод public void deleteById(int id)(подсказка: SQL запрос "DELETE FROM userTable WHERE id=?", метод jdbc.update) - удаления записи пользователя из БД по ID.
2) В класс UserService добавить метод public void deleteById(int id)(подсказка: в нем вызывается метод userRepository.deleteById) - удаление пользователя через репозиторий.
3) В класс UserController добавить метод public String deleteUser(@PathVariable("id") int id)(с аннотацией: @GetMapping("user-delete/{id}")) (подсказка: в нем вызывается метод userService.deleteById) - перехват команды на удаление студента от браузера.
Если задание выполнено верно, то при запуске приложения по адресу http://localhost:8080/users будет работать кнопка удаления пользователя по ID. [Решение](lesson2/src/main/java/ru/gb/)

## Урок 3. Использование Spring для разработки серверного приложения

) В класс RegistrationService добавить поля UserService, NotificationService(добавить в IOC контейнер аннотацией @Autowired или через конструктор класса)
2) Разработать метод processRegistration в котором:
- создается пользователь из параметров метода
- созданный пользователь добавляется в репозиторий
- через notificationService выводится сообщение в консоль
3) В TaskController добавить обработчики filterUsersByAge()(Подсказка @GetMapping("/filter/{age}")) и calculateAverageAge (Подсказка @GetMapping("/calc"))
4) В методе filterUsersByAge параметр age получать через аннотацию @PathVariable. [Решение](lesson_3/src/main/java/ru/gb/)

## Урок 4. Spring MVC. Использование шаблонизатора Thymeleaf

1. Создание базового веб-приложения Spring MVC
Начните с создания простого веб-приложения с использованием Spring MVC. Это может быть простой сайт, который выводит "Привет, мир!" на главной странице. Используйте аннотацию @Controller и @RequestMapping для маршрутизации запросов на эту страницу.
2. Добавление Thymeleaf в проект
Добавьте Thymeleaf в свое веб-приложение Spring MVC. Создайте простую страницу с некоторыми переменными, которые заполняются с помощью модели Spring MVC и отображаются на странице с использованием Thymeleaf.
3. Создание формы ввода и обработка данных формы
Создайте страницу с формой ввода, используя Thymeleaf для рендеринга формы. Затем создайте контроллер Spring MVC, который обрабатывает отправку формы и выводит полученные данные. Это может быть форма для регистрации или любая другая форма, которая собирает информацию от пользователя. [Решение](lesson_4/src/main/java/ru/gb/)

## Урок 5. Spring Data для работы с базами данных

Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA. Требуется реализовать следующие функции:
Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере: @GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
Изменение статуса задачи. Подсказка метод в контроллере: @PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
Удаление задачи.
Подсказка метод в контроллере:
@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id)
Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>
Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)
Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
} [Решение](lesson_5/src/main/java/ru/gb/)