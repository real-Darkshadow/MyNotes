
# Notes App

This is a simple, lightweight and user-friendly Notes application built with Room Database and a beautiful UI. With this app, you can easily take, store and manage all your notes in one place.


## Features

- Easy to create, edit and delete notes

- Store notes locally using Room Database

- Clean and beautiful user interface

- Supports text formatting (bold, italic, underline)

- Notes are saved automatically, no need to manually save


## Architecture

This app is built using the Model-View-ViewModel (MVVM) architecture pattern. This pattern separates the app into three layers:

- Model: This layer contains the data and business logic of the app. In this app, the Note class represents the data model for each note.

- View: This layer is responsible for displaying the UI to the user. In this app, the MainActivity class represents the view.

- ViewModel: This layer is responsible for handling the communication between the view and the model. In this app, the NoteViewModel class represents the view model.

The MVVM pattern allows for a clean separation of concerns and makes it easy to test each layer of the app independently.


## Libraries Used
This app uses the following libraries:

- LiveData: Used to observe changes in data and update the UI accordingly.
- ViewModel: Used to store and manage UI-related data.
- Room: Used to store and manage notes data locally.
## Screenshots

![App Screenshot](https://res.cloudinary.com/djejz6zgw/image/upload/v1677731161/bg_a6bfnr.png)
![App Screenshot](https://res.cloudinary.com/djejz6zgw/image/upload/v1677731161/1675772728771_100_sqp9nn.png)
![App Screenshot](https://res.cloudinary.com/djejz6zgw/image/upload/v1677731161/1675772738938_100_zot54j.png)
![App Screenshot](https://res.cloudinary.com/djejz6zgw/image/upload/v1677731161/1675772735888_100_c6cycd.png)


## Contributing

Contributions are always welcome! If you would like to contribute to this project, please fork the repository and create a pull request with your changes.


## License

This project is licensed under the MIT License - see the [LICENSE](https://choosealicense.com/licenses/mit/) file for details.
