# Fullstack Product Catalog

A full-stack e-commerce catalog application built with **Spring Boot (backend)**, **React + Vite (frontend)**, **PostgreSQL (database)**, and **Postman (API testing)**.  
This project demonstrates a complete product catalog system with authentication, product management, and cart functionality.

---

## 📂 Project Structure

fullstack-project/
│
├── backend/                  # Spring Boot backend
│   ├── src/                  # Java source code
│   ├── pom.xml               # Maven build file
│   └── ...                   # Other backend configs
│
├── frontend/                 # React + Vite frontend
│   ├── src/                  # React source code
│   ├── package.json          # Node dependencies
│   ├── vite.config.js        # Vite configuration
│   └── ...                   # Other frontend configs
│
├── db-dumps/                 # PostgreSQL dump files
│   ├── seed_data.sql         # Seed data for DB
│   └── product_catalog_backup.sql
│
├── postman/                  # Postman API collection
│   └── my-Collection.postman_collection
│
├── README.md                 # Project documentation
└── .gitignore                # Git ignore rules

Code

---

## 🚀 Getting Started

### 1. Backend (Spring Boot)
```cmd
cd backend
mvn spring-boot:run
Runs on: http://localhost:9090

2. Frontend (React + Vite)
cmd
cd frontend
npm install
npm run dev
Runs on: http://localhost:5173

3. Database (PostgreSQL)
Import seed data:

cmd
psql -U <username> -d <database> -f db-dumps/seed_data.sql
Backup file: db-dumps/product_catalog_backup.sql

4. API Testing (Postman)
Import postman/my-Collection.postman_collection into Postman.

Test endpoints like /api/products, /api/categories, /api/cart.

👥 Contributors
Chaithanya Raj Peddireddy (Owner)

Friend 1 (GitHub username to be added)

Friend 2 (GitHub username to be added)

🛠 Tech Stack
Backend: Spring Boot, Maven, JPA, PostgreSQL

Frontend: React, Vite, JavaScript, CSS

Database: PostgreSQL

Testing: Postman

🔄 Development Workflow
For Owner & Contributors
Clone the repo:

cmd
git clone https://github.com/Chaithanyarajpeddireddy/fullstack-product-catalog.git
cd fullstack-project
Create a new branch for your work:

cmd
git checkout -b feature/<feature-name>
Make changes locally → add, commit, and push:

cmd
git add .
git commit -m "Implemented <feature-name>"
git push origin feature/<feature-name>
Open a Pull Request (PR) on GitHub → request review → merge into main.

Keep your local repo updated:

cmd
git checkout main
git pull origin main
⚙️ Environment Variables
Backend (application.properties)
Code
spring.datasource.url=jdbc:postgresql://localhost:5432/product_catalog
spring.datasource.username=your_username
spring.datasource.password=your_password
Frontend (.env)
Code
VITE_API_URL=http://localhost:9090/api
📌 Notes
Checkout button is demo only.

Ensure PostgreSQL is running before starting backend.

Keep node_modules/ and target/ out of Git (see .gitignore).

Always work on branches, not directly on main.

Use Pull Requests for merging changes.

Code

---

## 📄 .gitignore

```gitignore
# Node.js / Frontend
node_modules/
dist/
.env

# Java / Maven / Backend
target/
*.class
*.log
*.jar
*.war
*.ear

# IDE / Editor
.vscode/
.idea/
*.iml
.classpath
.factorypath
.settings/
.project

# OS Files
.DS_Store
Thumbs.db

# Others
*.bak
*.tmp