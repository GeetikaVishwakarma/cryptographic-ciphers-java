# 🔐 Cryptographic Ciphers in Java

## 📌 Project Overview

This project is a Java-based application that demonstrates classical cryptographic techniques for encrypting and decrypting text.

It includes:

* Caesar Cipher
* Vigenère Cipher

The program is menu-driven and allows users to choose different encryption methods interactively.

---

## 🚀 Features

* Caesar Cipher (Encryption & Decryption)
* Vigenère Cipher (Encryption & Decryption)
* Menu-driven interface
* Handles uppercase and lowercase letters

---

## 🛠️ Technologies Used

* Java
* Object-Oriented Programming
* Scanner Class (for user input)

---

## ▶️ How to Run

1. Compile the program:

   ```
   javac Main.java
   ```

2. Run the program:

   ```
   java Main
   ```

---

## 📂 Project Structure

```id="struct2"
Cryptographic-Ciphers-Java/
│
├── Main.java
└── README.md
```

---

## 🔑 Caesar Cipher

### 📌 Description

A simple substitution cipher where each letter is shifted by a fixed number.

### 🔢 Example

Plain Text: HELLO
Shift: 3

Encrypted: KHOOR

---

## 🔐 Vigenère Cipher

### 📌 Description

A more secure cipher that uses a keyword to apply different shifts to each character.

### 🔢 Example

Plain Text: HELLO
Key: KEY

Encrypted: RIJVS

---

## 💡 Sample Output

```id="output1"
--- Cryptographic Ciphers ---
1. Caesar Cipher
2. Vigenere Cipher
3. Exit

Enter choice: 1
Enter text: HELLO
Enter shift: 3

Encrypted: KHOOR
Decrypted: HELLO
```

---

## 🎯 Learning Outcomes

* Understanding of encryption and decryption techniques
* Implementation of classical cryptographic algorithms
* Hands-on practice with Java programming.
