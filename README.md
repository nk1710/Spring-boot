# Spring-boot
⭐ PART 1 — @RestController future me kis-kis tarah use hota hai?
@RestController ka use har jagah hota hai jab aap backend API banate ho.
@RestController = Ye class internet se aayi request ka jawab degi.

Browser → /greet
           ↓
@RestController (Waiter)
           ↓
Method → Response → Browser me print

Ek ultra simple analogy (yaad rakhne ke liye)
👉 @RestController = Agar is label ko hata doge, to controller kaam nahi karega.

Jaise:

Police bina uniform → koi nahi pehchaanega

Doctor bina coat → koi nahi samjhega

Waiter bina uniform → customer confuse ho jayega

Controller bina @RestController → Spring confuse ho jayega

@RestController = Spring ko batata hai ki ye class REST API handle karegi. Iske saare methods API response (JSON/text) return karenge.


PART 2 — @GetMapping future me kaise use hota hai?

@GetMapping sabse zyada used annotation hota hai.

Ye “data fetch karne” ke liye hota hai.

✔ 1️⃣ Show all users
@GetMapping("/users")
public List<User> getUsers() {
    return userService.getAll();
}

✔ 2️⃣ Single user details
@GetMapping("/users/{id}")
public User getUser(@PathVariable int id) {
    return userService.getById(id);
}

✔ 3️⃣ Search APIs (Bahut use hota hai future me)
@GetMapping("/search")
public List<Product> search(@RequestParam String keyword) {
    return productService.search(keyword);
}


Example use:

/search?keyword=shoes

✔ 4️⃣ Filtering APIs (Airlines / Hotels / Shops me use)
@GetMapping("/flights")
public List<Flight> getFlights(@RequestParam String from, @RequestParam String to) {
    return flightService.findFlights(from, to);
}


Call:

/flights?from=Delhi&to=Mumbai

✔ 5️⃣ Dashboard ke liye stats (Admin panel me use)
@GetMapping("/stats")
public Stats getStats() {
    return adminService.getDashboardStats();
}


Auto-Configuration kya hota hai? (Super Easy Definition)
👉 **Spring Boot automatically guess karta hai ki aapko project me kya chahiye,

और woh cheezein khud-ba-khud configure kar deta hai — bina aapko code likhe.**


Real Life Example (Most Important)

Socho aap ek hotel me gaye.

Aapne bola:

“Mujhe normal room chahiye.”

Hotel wale automatically:

bed ready

towel rakh diya

water bottle rakh di

AC on

room clean

mattress perfect

Aapne kuch nahi bola — sab kuch automatically mil gaya.

Yahi Spring Boot me hota hai.

⭐ Coding Example (Aapke project me IN REAL)

Aapne apne project me bas ye dependency add ki:

spring-boot-starter-web


Bas!
Aapne kuch aur nahi likha.

Lekin Spring Boot NE AUTOMATICALLY:

✔ Tomcat server chalu kar diya
✔ Port 8080 set kar diya
✔ DispatcherServlet bana diya
✔ JSON converter laga diya
✔ Exception handler chalu kar diya
✔ Controller scan karna start kar diya

Aapne ek line bhi config nahi likhi – sab Auto-Configuration se hota hai.

⭐ Auto-Configuration chal kaise sakta hai?

Spring Boot me ek annotation hai:

@SpringBootApplication


Iske andar hota hai:

@EnableAutoConfiguration


Iski wajah se Spring Boot khud guess karta hai:

Web dependency hai → Tomcat chalu karo

JPA dependency hai → Hibernate configure karo

MySQL dependency hai → DataSource configure karo

Thymeleaf dependency hai → Template resolver bana do

Aap kuch mat karo, Spring sab kar deta hai.

⭐ VERY SIMPLE SUMMARY (YAAD RAHNE WALI LINE)
🔥 Auto-Configuration = Spring Boot ki automatic setting system

Jisme Spring aapke project ke hisaab se features automatically ON kar deta hai.

⭐ Interview Definition (1 line)

Auto-Configuration automatically configures Spring components based on the dependencies present in the classpath.


RequestParam = chhoti information URL se lena.







@GetMapping("/user/{id}")
public String getUser(@PathVariable int id) {
    return "User ID is " + id;
}
Browser:

bash
Copy code
http://localhost:8080/user/10
Output:

pgsql
Copy code
User ID is 10
💡 PathVariable = “ID URL ka part ho.”





1) @PostMapping KYA HOTA HAI? (Ultra Simple)
👉 Jab hume data bhejna hota hai server ko

tab hum POST request use karte hain.

Isko Spring Boot me likhte hain:

@PostMapping("/something")

⭐ 2) REAL LIFE EXAMPLES (Super Important)

Zomato me order place karte ho →
Ye POST request hoti hai:

POST /order
body = { "itemId": 42, "qty": 2 }


Flipkart me signup form submit → POST request.

Login → POST request.

Facebook me post upload → POST request.

Jahan data bhejna hai → POST.
Jahan data lena hai → GET.











| Concept                    | Meaning                                     |
| -------------------------- | ------------------------------------------- |
| **JPA**                    | Rules (kaam kaise karna hai)                |
| **Hibernate**              | Worker (database me actual SQL chalata hai) |
| **Entity**                 | Java class → MySQL table                    |
| **@Id**                    | Primary key                                 |
| **@GeneratedValue**        | ID auto-generate                            |
| **JpaRepository**          | CRUD bina code likhe                        |
| **Derived Methods**        | Method name se SQL ban jayega               |
| **application.properties** | MySQL connection + Hibernate settings       |


📌 DTO:

Request/Response structure define karta hai

Data ko organize karta hai

Entity ko protect karta hai

Cleaner architecture deta hai

📌 ModelMapper:

DTO ↔ Entity conversion automatically karta hai

Manual setters likhne ki zarurat nahi

Clean & short code