# TP Youssefi 2 — Application Spring Boot

## 📌 Description
Application Spring Boot avec gestion des produits et des patients, sécurité Spring Security, vues Thymeleaf et interface Bootstrap 5.

## ✅ Fonctionnalités
- Authentification (Spring Security)
- Gestion des produits (liste, recherche, ajout, édition, suppression)
- Gestion des patients (liste)
- Validation des formulaires (Jakarta Validation)
- Interface web avec Thymeleaf + Bootstrap 5

## 🧰 Stack technique
- Java 17
- Spring Boot 3.5.x
- Spring Data JPA
- Spring Security 6
- Thymeleaf
- H2 (mémoire)
- Bootstrap 5 (CDN)

## 🚀 Lancer le projet
### Avec Maven Wrapper
```bash
./mvnw spring-boot:run
```

### Sous Windows (PowerShell)
```powershell
.\mvnw.cmd spring-boot:run
```

L’application démarre sur : http://localhost:8080

## 🔐 Comptes de test
- **user / 1234**
- **admin / 1234**

## 🌐 Pages principales
- Produits : http://localhost:8080/products
- Patients : http://localhost:8080/patients
- Connexion : http://localhost:8080/login
- Console H2 : http://localhost:8080/h2-console

## 🗃️ Base de données (H2)
- URL JDBC : `jdbc:h2:mem:dbproduits`
- User : `sa`
- Password : *(vide)*

## 📁 Structure du projet
```
src/main/java/com/example/demo
├─ Product, Patient, Medecin, RendezVous, Consultation
├─ AppUser, AppRole
├─ Controllers (ProductController, PatientController)
└─ SecurityConfig

src/main/resources/templates
├─ template.html
├─ products.html
├─ formProduct.html
└─ patients.html
```

## 📝 Notes
- Les données sont initialisées au démarrage (produits + patients).
- La recherche de produits est insensible à la casse.
