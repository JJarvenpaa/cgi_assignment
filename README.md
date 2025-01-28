# Install files
```bash
./mvnw generate-resources
```

# Start Java backend
Go to src/main/java/com/example/demo/ApiController.java and run it from your IDE
Now the backend is running

# Array Tests
Are located in src/main/test/java/com/example/demo/ArrayApplicationTests.java

Array assignment: 

Write a Java program with a unit test that determines the smallest number of numbers that can fit between the different numbers in a table in a natural order.

For example, the correct answer for a table [ 1, 4, 10 ] would be 2, since the numbers 2 and 3 would fit between 1 and 4, and a larger number of digits would fit between the other numbers.
- The function can assume that all elements of the table contain a natural number
- The function must work in the same way even if the order of the numbers in the table changes
- The function must work in the same way even if there are more than one of the same number in the table
- The function must work in the same way even if several numbers in the table have the same length of space, e.g. [ 1, 3, 5 ]

# Client

This project was generated using [Angular CLI](https://github.com/angular/angular-cli) version 19.0.3.

## Development server

To start a local development server, run:

```bash
./ng serve
```

Once the server is running, open your browser and navigate to `http://localhost:4200/`. The application will automatically reload whenever you modify any of the source files.

## Code scaffolding

Angular CLI includes powerful code scaffolding tools. To generate a new component, run:

```bash
./ng generate component component-name
```

For a complete list of available schematics (such as `components`, `directives`, or `pipes`), run:

```bash
./ng generate --help
```

## Building

To build the project run:

```bash
./ng build
```

This will compile your project and store the build artifacts in the `dist/` directory. By default, the production build optimizes your application for performance and speed.

## Running unit tests

To execute unit tests with the [Karma](https://karma-runner.github.io) test runner, use the following command:

```bash
./ng test
```

## Running end-to-end tests

For end-to-end (e2e) testing, run:

```bash
./ng e2e
```

Angular CLI does not come with an end-to-end testing framework by default. You can choose one that suits your needs.

## Additional Resources

For more information on using the Angular CLI, including detailed command references, visit the [Angular CLI Overview and Command Reference](https://angular.dev/tools/cli) page.
