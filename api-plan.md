# API Requirements for Hackathon Platform

## 1. User Authentication & Registration

### User Registration
Users can register using the following fields:
- **`firstname`** (string)
- **`lastname`** (string)
- **`email`** (string) – Must be a valid email. If the user is a KIU student, the domain must be `kiu.edu.ge`.
- **`password`** (string)
- **`skills`** (text) – A text description of skills
- **`is_kiu_student`** (boolean)
- **`profile_picture`** (file/image)

### User Login & Authentication
- Users log in using:
  - **`email`** (string)
  - **`password`** (string)
- The system issues a **JWT token** for authentication.
- Users can **log out**, which invalidates their session/token.

---

## Models

### 2. User

- **`id`** (integer)
- **`firstname`** (string)
- **`lastname`** (string)
- **`email`** (string)
- **`skills`** (text) - text desctiption of skills
- **`is_kiu_student`** (boolean)
- **`profile_picture`** (string) 

---

### 3. Hackathon

At the start of the hackaton min team size members at least.

- **`id`** (integer).
- **`start_date`** (date)
- **`topic`** (string) 
- **`description`** (text) – Detailed description of the hackathon.
- **`min_team_size`** (integer)
- **`max_team_size`** (integer) 

---

### 4. Prize 

Prize objects are created for every hackaton separately.

- **`id`** (integer)
- **`hackaton_id`** (integer) - associated hacakton
- **`description`** (string) – Prize description (e.g., "1st place").
- **`quantification`** (string) – Prize value (e.g., "1000 dollars").

### 6. Team 

- **`id`** (integer) – Unique identifier.
- **`hackathon_id`** (integer) – Reference to the hackathon the team is participating in.
- **`team_number`** (integer) – Assigned team number, like team 7.
- **`team_leader_id`** (integer) – Reference to the user who is the team leader.
- **`team_description`** (text) – Team description (e.g., "Looking for a UI designer").

## Relationships


### 7. Team Member

- **`team_id`** (integer) – Reference to the associated team.
- **`user_id`** (integer) – Reference to the user who is a part of the team.

---

### 8. Hackaton Winner

- **`id`** (integer) – Unique identifier.
- **`team_id`** (integer) – Reference to the winning team.
- **`prize_id`** (integer) – Reference to the associated prize for that hackathon.

---



