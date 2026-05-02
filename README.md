# Hospital Hibernate Project — KLEF FSAD Exam

A Maven + Hibernate project that performs **Insert** and **View-by-ID** operations on a `Hospital` entity using a MySQL database named `fsadendexam`.

---

## 📁 Project Structure

```
HospitalHibernate/
├── pom.xml
├── README.md
└── src/
    └── main/
        ├── java/
        │   └── com/klef/fsad/exam/
        │       ├── Hospital.java       ← Entity / Persistent class
        │       ├── HibernateUtil.java  ← SessionFactory helper
        │       └── ClientDemo.java     ← Main class (Insert + View)
        └── resources/
            └── hibernate.cfg.xml       ← Hibernate + DB config
```

---

## ✅ Prerequisites

| Tool | Version |
|------|---------|
| Java (JDK) | 11 or above |
| Maven | 3.6+ |
| MySQL Server | 5.7 / 8.x |

---

## ⚙️ Database Setup

1. Start your MySQL server.
2. Create the database (Hibernate can also auto-create it via the JDBC URL flag):

```sql
CREATE DATABASE IF NOT EXISTS fsadendexam;
```

3. Open `src/main/resources/hibernate.cfg.xml` and update the credentials:

```xml
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">root</property>
```

> **Tip:** The JDBC URL already contains `createDatabaseIfNotExist=true`, so the DB is created automatically if it doesn't exist.

---

## ▶️ Steps to Run

### Option A — Maven command line

```bash
# 1. Navigate to project root
cd HospitalHibernate

# 2. Build the project
mvn clean package

# 3. Run ClientDemo
mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"
```

### Option B — Eclipse / IntelliJ

1. `File → Import → Existing Maven Projects` → select the `HospitalHibernate` folder.
2. Wait for Maven to download dependencies.
3. Open `ClientDemo.java`.
4. Right-click → `Run As → Java Application`.

---

## 🗄️ What the Program Does

| # | Operation | Hibernate Method |
|---|-----------|-----------------|
| I | Insert a new Hospital record | `session.save(hospital)` |
| II | View the record by auto-generated ID | `session.get(Hospital.class, id)` |

---

## 🏥 Hospital Entity Fields

| Field | Column | Type | Notes |
|-------|--------|------|-------|
| id | hospital_id | INT | Auto-generated (PK) |
| name | hospital_name | VARCHAR(150) | Required |
| description | description | VARCHAR(500) | |
| date | established_date | DATE | |
| status | status | VARCHAR(50) | e.g., Active |
| location | location | VARCHAR(200) | |
| contactNumber | contact_number | VARCHAR(15) | |
| email | email | VARCHAR(100) | |
| numberOfBeds | number_of_beds | INT | |

---

## 📦 Dependencies (pom.xml)

- `hibernate-core` 5.6.15.Final
- `mysql-connector-java` 8.0.33
- `jakarta.persistence-api` 2.2.3

---

## 📝 Sample Output

```
============================================
  KLEF FSAD EXAM — Hospital Hibernate Demo
  Database : fsadendexam
============================================

========================================
  OPERATION I : INSERT HOSPITAL RECORD
========================================
Hibernate:
    insert into hospital (...) values (...)

[SUCCESS] Hospital record inserted successfully!
  Generated Hospital ID : 1
  Hospital Name         : KLEF Super Specialty Hospital

========================================
  OPERATION II : VIEW RECORD BY ID = 1
========================================
Hibernate:
    select hospital0_.hospital_id as ...

[SUCCESS] Hospital record found:

Hospital {
  ID            : 1
  Name          : KLEF Super Specialty Hospital
  Description   : A leading multi-specialty hospital ...
  Established   : 2005-06-15
  Status        : Active
  Location      : Vijayawada, Andhra Pradesh
  Contact       : 0866-2450100
  Email         : info@klefhospital.ac.in
  No. of Beds   : 500
}
```
