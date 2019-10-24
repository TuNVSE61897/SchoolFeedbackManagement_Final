1. Project Information
- Project name: School Feedback Management System
- Project Code: SFMS
- Product Type: Web app, Mobile App
- Start Date: 08/01/2018
- End Date: 29/04/2018
- Tools andTechniques:
Frontend: HTML, CSS, JavaScript, Bootstrap, Thymeleaf
Backend: SpringBoot framework, Java
IDE: NetBeans 8.2, IntelliJ IDEA 17.2, Android Studio 3.0
Database: MySQL 5.7
Modelling tool: Star UML 2.8.0
Source control: Github
Web browser: Chrome 42 or above
Application Server: Tomcat 8.0

=================================

2. Introduction
In this document, we introduce a solution for School Feedback System. Current
feedback systems have some problems like impossible to design and customize feedback
form that suitable for each major, lecture, course, or inconvenient in analyzing results.
Base on our reaserches and analysis, we proposed a solution for university in Vietnam and
other developed countries.
We build a system, which helps the universities solve current problems. In the process
of analysis, we believe our system is capable to resolve the problem by let users create,
design, and customize feedback form through dragging and dropping items. Besides that,
we also analyze feedback results and provide reports and suggested improvements, based
on the results.
This document also describes our working process in 4 months includes our
perspective in the system, component designs and detailed core workflows. We hope the
system and our solution will help resolve the problems from universities in Vietnam and
other developed countries.

=================================

3. Current Situation
Currently, in university, we use the same feedback form for every courses and
major. So we can just gain feedback of some general information like: if lecturer is
on time, if the students can understand the lecture, how skillful the lecturer is...
When feedback period’s over, the results will send to lecturer without analysing
or providing suggested improvement.

=================================

4. Problem Definition

 Customize Feedback form:
- Use same questions set for all classes, courses, majors
- Can’t question unique aspect of each course (For example: Can’t question about accent of
English lecturer)
- Lack of usefulness and practicality (Can only ask same general questions that used for all
courses)
- Hardly use for personal improvement
- Can’t modify targets or conductors of Feedback
- Can’t choose type of feedback survey (Feedback for class, course, major, or for
department)

 Analyze results and Report
- Can’t generate graphical charts of statistical results from feedback answersFPT University – Capstone Spring 2018 – Group 11 – School Feedback Management System
- Can’t compare results in the past to current
- Don’t provide suggested improvement to lecturers

 Conduct Feedback
- Edit answers

=================================

5. Proposed Solution
Our proposed solution is to build a system named School Feedback Manage System can dragn-drop feedback items to create new feedback form to resolve those problems of current
situations.
SFMS includes a web application to manage and create feedback, and mobile app to conduct
feedback, with following functions:

5.1. Feature functions
 Web Application:
- Create new Feedback form: choose existed template or customize by dragging and dropping items to the
form
- Save created feedback template
- Choose scope of Feedback: Feedback for a lecture, a major, a course or a department
- Set suggested improvement based on average points of each feedback
- Set interval time for each Feedback
- Remind users to conduct Feedback
- Search and Filter feedback
- Conduct Feedback
- Edit Answers
- Search and Filter reports
- Compare points in the past to current through semester
- View report in details

 Mobile Application:
- View list Feedback
- Conduct Feedback
- Edit answer

5.2. Advantages and disadvantages

 Advantages:
- Make realistic improvement from feedback
- Help Head of Academic follows real performance of lecturers
- Feedback can use in different subjects, courses, majors, lecturer, departments
- Represent results as graphical charts
- Save created feedback form to

 Disadvantages:
- Staffs have to spend time to design feedback form
- Input suggested improvement manually
