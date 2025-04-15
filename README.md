📸 Instagram LLD System Design (Java + Multithreading)
This project is a Low-Level Design (LLD) simulation of a simplified Instagram-like social media platform, developed in Java using object-oriented principles, multithreading, and design patterns. It demonstrates real-world backend concepts such as user profiles, posts, reels, likes, comments, follow requests, and timelines.

-------------

## 🛠️ Tech Stack

- **Language**: Java 8+
- **Design Principles**: OOPs, Design Patterns
- **Multithreading**: Used for safe operations like likes/comments
- **Architecture**: Layered (DTO, Service, Interfaces)
---

## 🚀 Features Implemented

- **User Profile Management**
  - Create user profiles
  - Mark users as celebrities
  - Maintain followers and followings
  
- **Follow Request System**
  - Send follow requests
  - Accept/Reject requests (especially useful for celebrity profiles)

- **Posts Management**
  - Create and view posts
  - Like/unlike posts
  - Comment on posts

- **Reels Feature (Short Videos)**
  - Upload reels with captions and video links
  - Like and comment on reels
  - Timeline integration with reels

- **Timeline Feature**
  - Fetch timeline based on last seen
  - View new posts/reels from followed profiles

- **Multithreading for Likes**
  - Ensures thread-safe like/unlike operations using `ReentrantLock`

---

