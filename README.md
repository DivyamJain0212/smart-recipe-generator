# 🍽️ Smart Recipe Generator

A **Spring Boot** application that helps users generate recipe suggestions based on available ingredients, dietary preferences, and difficulty levels. Features a clean web interface with planned integration of Google Cloud Vision API for intelligent ingredient detection from images.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green)
![Maven](https://img.shields.io/badge/Maven-3.6+-blue)
![Docker](https://img.shields.io/badge/Docker-Ready-blue)

---

## 🚀 Features

✅ **Smart Recipe Search** - Find recipes based on your available ingredients  
✅ **Dietary Filters** - Vegetarian, Vegan, Non-Vegetarian, Gluten-Free options  
✅ **Difficulty Levels** - Easy, Medium, Hard recipe categories  
✅ **Time Management** - Set maximum cooking time preferences  
✅ **Image Recognition** - Upload ingredient photos (powered by Google Vision API)  
✅ **User Engagement** - Rate and favorite your preferred recipes  
✅ **Sample Data** - Pre-loaded recipes from `recipes.json`  
✅ **Responsive Design** - Mobile-friendly UI with Bootstrap 5  

---

## 🏗️ Project Structure

```
smart-recipe-generator/
├── .dockerignore
├── Dockerfile
├── pom.xml
├── credentials.json                 # Google Cloud Vision credentials
├── src/
│   ├── main/
│   │   ├── java/com/example/recipe/
│   │   │   ├── RecipeApplication.java
│   │   │   ├── controller/
│   │   │   ├── model/
│   │   │   ├── service/
│   │   │   └── repository/
│   │   ├── resources/
│   │   │   ├── application.properties
│   │   │   └── recipes.json         # Sample recipe data
│   │   └── static/
│   │       ├── index.html           # Main web interface
│   │       └── css/style.css        # Custom styles
│   └── test/java/com/example/recipe/
└── target/                          # Maven build output
```

---

## ⚙️ Prerequisites

- **Java 17** or higher
- **Maven 3.6+** for dependency management
- **Google Cloud Vision API** credentials (optional for image features)

---

## 🚀 Quick Start

### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/smart-recipe-generator.git
cd smart-recipe-generator
```

### 2. Configure Google Cloud Vision (Optional)
Place your `credentials.json` file in the project root directory.

### 3. Build the Project
```bash
mvn clean package
```

### 4. Run the Application
```bash
mvn spring-boot:run
```

### 5. Access the Web Interface

Open your browser and navigate to: **http://localhost:8080**

Or try the live deployed version here: **https://smart-recipe-generator-sbe8.onrender.com/**

---
## 📷 Screenshot
![image](https://github.com/user-attachments/assets/42f86fd1-83f6-496d-ac8b-dc3faa1aee43)

---
## 🐳 Docker Deployment

### Build Docker Image
```bash
docker build -t smart-recipe-generator .
```

### Run Container
```bash
docker run -p 8080:8080 smart-recipe-generator
```

The application will be available at **http://localhost:8080**

---

## 📚 API Documentation

### Recipe Search Endpoint
```http
POST /api/recipes
Content-Type: application/json

{
  "ingredients": ["chicken", "tomato", "onion"],
  "dietaryPreference": "NON_VEGETARIAN",
  "difficulty": "MEDIUM",
  "maxCookingTime": 30
}
```

### Image Ingredient Detection (Future Feature)
```http
POST /api/ingredients/image
Content-Type: multipart/form-data

file: [image file]
```

---

## 🛠️ Technologies Stack

| Technology | Purpose |
|------------|---------|
| **Spring Boot** | Main application framework |
| **Spring Web** | REST API development |
| **Spring Data JPA** | Database operations |
| **H2 Database** | In-memory database |
| **Google Cloud Vision API** | Image ingredient recognition |
| **Maven** | Build and dependency management |
| **Bootstrap 5** | Responsive UI framework |
| **JavaScript** | Frontend interactivity |
| **Docker** | Containerization |

---

## 🧪 Testing

### Run Unit Tests
```bash
mvn test
```

### Run Integration Tests
```bash
mvn verify
```

---

## 🤝 Contributing

We welcome contributions! Please follow these steps:

1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature/amazing-feature`)
3. **Commit** your changes (`git commit -m 'Add amazing feature'`)
4. **Push** to the branch (`git push origin feature/amazing-feature`)
5. **Open** a Pull Request

### Code Style Guidelines
- Follow Java naming conventions
- Write meaningful commit messages
- Include unit tests for new features
- Update documentation as needed

---

## 🌟 Acknowledgments

- Built with ❤️ using **Spring Boot** and **Google Cloud** tools  
- **Bootstrap** team for the responsive UI components  
- **ChatGPT by OpenAI** for assistance with ideation, coding, and documentation  
- The **open-source community** for constant inspiration and support  


---

## 📞 Support

If you encounter any issues or have questions:

1. Check the [Issues](https://github.com/yourusername/smart-recipe-generator/issues) page
2. Create a new issue if your problem isn't already reported
3. Contact the maintainers at divyamjain2contact@gmail.com

---

## 🔮 Future Enhancements

- [ ] Image-based ingredient recognition using computer vision
- [ ] Advanced ingredient substitution suggestions
- [ ] Nutritional information integration
- [ ] Shopping list generation
- [ ] Social recipe sharing
- [ ] Mobile app development
- [ ] Multi-language support


---

**Happy Cooking! 👨‍🍳👩‍🍳**
