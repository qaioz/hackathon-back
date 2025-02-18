# API Requirements for Hackathon Platform

## User Authentication & Registration

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

### User

- **`id`** (integer)
- **`firstname`** (string)
- **`lastname`** (string)
- **`email`** (string)
- **`skills`** (text) - text desctiption of skills
- **`is_kiu_student`** (boolean)
- **`profile_picture`** (string) 

---

### Hackathon

At the start of the hackaton min team size members at least.

- **`id`** (integer).
- **`start_date`** (date)
- **`topic`** (string) 
- **`description`** (text) – Detailed description of the hackathon.
- **`min_team_size`** (integer)
- **`max_team_size`** (integer) 

---

### Prize 

Prize objects are created for every hackaton separately.

- **`id`** (integer)
- **`hackaton_id`** (integer) - associated hacakton
- **`description`** (string) – Prize description (e.g., "1st place").
- **`quantification`** (string) – Prize value (e.g., "1000 dollars").

### Team 

- **`id`** (integer) – Unique identifier.
- **`hackathon_id`** (integer) – Reference to the hackathon the team is participating in.
- **`team_number`** (integer) – Assigned team number, like team 7.
- **`team_leader_id`** (integer) – Reference to the user who is the team leader.
- **`team_description`** (text) – Team description (e.g., "Looking for a UI designer").

## Relationships


### Team Member

- **`team_id`** (integer) – Reference to the associated team.
- **`user_id`** (integer) – Reference to the user who is a part of the team.

---

### Hackaton Winner

- **`id`** (integer) – Unique identifier.
- **`team_id`** (integer) – Reference to the winning team.
- **`prize_id`** (integer) – Reference to the associated prize for that hackathon.

---

## Endpoints

### User Authentication & Registration
- **Register User**  
  - **Endpoint**: `POST /api/auth/register`  
  - **Privilege**: Public  

- **Login User**  
  - **Endpoint**: `POST /api/auth/login`  
  - **Privilege**: Public  

- **Logout User**  
  - **Endpoint**: `POST /api/auth/logout`  
  - **Privilege**: Authenticated  

---

### User Management
- **Get User Profile**  
  - **Endpoint**: `GET /api/users/{user_id}/profile`  
  - **Privilege**: Public  

- **Update User Profile**  
  - **Endpoint**: `PATCH /api/users/{user_id}`  
  - **Privilege**: Authenticated  

- **Delete User (Admin)**  
  - **Endpoint**: `DELETE /api/users/{user_id}`  
  - **Privilege**: Admin  

---

### Hackathon Management
- **Create Hackathon**  
  - **Endpoint**: `POST /api/hackathons`  
  - **Privilege**: Admin  

- **Get All Hackathons**  
  - **Endpoint**: `GET /api/hackathons`  
  - **Query Parameters**:
    - `status=finished` – Filter finished hackathons.
    - `status=ongoing` – Filter ongoing hackathons.
  - **Privilege**: Public  

- **Get Hackathon Details**  
  - **Endpoint**: `GET /api/hackathons/{hackathon_id}`  
  - **Privilege**: Public  

- **Update Hackathon (Admin)**  
  - **Endpoint**: `PATCH /api/hackathons/{hackathon_id}`  
  - **Privilege**: Admin  

- **Delete Hackathon (Admin)**  
  - **Endpoint**: `DELETE /api/hackathons/{hackathon_id}`  
  - **Privilege**: Admin  

---

### Team Management
- **Create Team**  
  - **Endpoint**: `POST /api/teams`  
  - **Privilege**: Authenticated  

- **Get All Teams**  
  - **Endpoint**: `GET /api/teams`  
  - **Query Parameters**:
    - `hackathon_id={hackathon_id}` – Filter teams by hackathon.
  - **Privilege**: Public  

- **Get Team Details**  
  - **Endpoint**: `GET /api/teams/{team_id}`  
  - **Privilege**: Authenticated  

- **Update Team (Team Leader)**  
  - **Endpoint**: `PATCH /api/teams/{team_id}`  
  - **Privilege**: Team Leader  

- **Delete Team (Team Leader or Admin)**  
  - **Endpoint**: `DELETE /api/teams/{team_id}`  
  - **Privilege**: Team Leader or Admin  

---

### Team Join Requests
- **Request to Join a Team**  
  - **Endpoint**: `POST /api/teams/{team_id}/join-requests`  
  - **Privilege**: Authenticated  

- **Get Team Join Requests (Team Leader)**  
  - **Endpoint**: `GET /api/teams/{team_id}/join-requests`  
  - **Privilege**: Team Leader  

- **Approve/Reject Team Join Request**  
  - **Endpoint**: `PATCH /api/teams/{team_id}/join-requests/{request_id}`  
  - **Privilege**: Team Leader  

---

### Notifications
- **Get Notifications (for User)**  
  - **Endpoint**: `GET /api/users/{user_id}/notifications`  
  - **Privilege**: Authenticated  

- **Mark Notification as Read**  
  - **Endpoint**: `PATCH /api/users/{user_id}/notifications/{notification_id}`  
  - **Privilege**: Authenticated  

---

### Prize Management
- **Create Prize (Admin)**  
  - **Endpoint**: `POST /api/prizes`  
  - **Privilege**: Admin  

- **Get Prizes for Hackathon**  
  - **Endpoint**: `GET /api/hackathons/{hackathon_id}/prizes`  
  - **Privilege**: Public  

- **Update Prize (Admin)**  
  - **Endpoint**: `PATCH /api/prizes/{prize_id}`  
  - **Privilege**: Admin  

- **Delete Prize (Admin)**  
  - **Endpoint**: `DELETE /api/prizes/{prize_id}`  
  - **Privilege**: Admin  

---

### Hackathon Winners
- **Declare Hackathon Winner (Admin)**  
  - **Endpoint**: `POST /api/hackathons/{hackathon_id}/winners`  
  - **Privilege**: Admin  

- **Get Hackathon Winners**  
  - **Endpoint**: `GET /api/hackathons/{hackathon_id}/winners`  
  - **Privilege**: Public  

---

### Admin Endpoints
- **Get All Teams (Admin)**  
  - **Endpoint**: `GET /api/admin/teams`  
  - **Privilege**: Admin  

- **Get All Users (Admin)**  
  - **Endpoint**: `GET /api/admin/users`  
  - **Privilege**: Admin  

- **Delete Team (Admin)**  
  - **Endpoint**: `DELETE /api/admin/teams/{team_id}`  
  - **Privilege**: Admin  

- **Delete User (Admin)**  
  - **Endpoint**: `DELETE /api/admin/users/{user_id}`  
  - **Privilege**: Admin  



