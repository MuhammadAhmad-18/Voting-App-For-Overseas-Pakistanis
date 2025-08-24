# 🗳️ Online Voting Application for Overseas Pakistanis  

A mobile application built using **Java** and **Android Studio** that enables overseas Pakistanis to cast their votes securely, ensuring transparency and preventing re-voting. The app follows **Object-Oriented Programming (OOP)** principles and demonstrates the use of encapsulation, inheritance, polymorphism, and abstraction.  

---

## 🚀 Features
- **User Authentication**: Login system to verify voters.  
- **Credential Verification**: Voters provide their CNIC/passport details for validation.  
- **Party Selection**: Users can view party options and cast their vote.  
- **Secure Vote Casting**: Once a vote is submitted, the status is updated to prevent re-voting.  
- **Vote Status Tracking**: Ensures that a voter can only cast one vote.  
- **User-Friendly UI**: Built with **XML layouts** for smooth navigation.  

---

## 🛠️ Tech Stack
- **Frontend**: Android XML Layouts  
- **Backend**: Java (Android SDK)  
- **IDE**: Android Studio  
- **Database (Optional)**: Firebase / Local Storage (for demo version)  

---

## 📂 Project Structure
VotingApp/
│
├── app/src/main/java/com/example/votingapp/
│ ├── LoginActivity.java # Handles user login
│ ├── CredentialActivity.java # Verifies CNIC/passport details
│ ├── VoteActivity.java # Allows party selection and vote casting
│ ├── models/ # OOP models (User, Voter, Party, Vote)
│ └── utils/ # Helper classes
│
├── app/src/main/res/layout/
│ ├── activity_login.xml # Login screen UI
│ ├── activity_credential.xml # Credentials screen UI
│ ├── activity_vote.xml # Vote casting UI

🏛️ OOP Concepts Implemented
<ul>
<li>Encapsulation: Sensitive user data (credentials, votes) is protected via private fields and getters/setters.</li>

<li>Inheritance: User and Voter classes demonstrate base-class and subclass relationships.</li>

<li>Polymorphism: Different types of users (Admin, Voter) handle login and actions differently.</li>

<li>Abstraction: Interfaces and abstract classes used for vote handling and verification logic.</li>
</ul>

🤝 Contributing
Contributions are welcome! Please fork this repo, create a branch, and submit a pull request.

👨‍💻 Author
Muhammad Ahmad
Student at NUST, Islamabad
