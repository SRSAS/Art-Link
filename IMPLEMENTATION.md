# Implementation Plan
## Current Sprint
### Sprint Goal
Implement initial functionalities. Implement basic frontend pages, and allow users to register, login, search users, and see profile pages.

### Sprint Backlog
- :white_large_square: User backend structure;
- :white_large_square: Auth backend structure;
- :white_large_square: Homepage frontend;
- :white_large_square: User authentication frontend (register and login);
- :white_large_square: User profile page frontend;
- :white_large_square: Search page frontend;

### Sprint Tasks
#### Legend
:white_large_square: = Task not started yet

:clock10: = Task in progress

:white_check_mark: =  Task completed

#### User backend structure
- :white_large_square: Implement User class;
- :white_large_square: Setup user profile picture backend management;
- :white_large_square: Implement UserDto class;
- :white_large_square: Implement User repository;
- :white_large_square: Implement User service: registerUser;
- :white_large_square: Implement User service: getUsersByNameExpression;
- :white_large_square: Implement User service: getUserById;
- :white_large_square: Implement User REST service registerUser;
- :white_large_square: Implement User REST service getUsersByNameExpression;
- :white_large_square: Implement User REST service: getUserById;
#### Auth backend structure
- :white_large_square: Implement AuthUser class;
- :white_large_square: Implement AuthUserDto class;
- :white_large_square: Implement AuthUser repository;
- :white_large_square: Implement AuthUser service loginUser();
- :white_large_square: Implement AuthUser service logoutUser();
- :white_large_square: Implement AuthUser service getDemoUser();
- :white_large_square: Implement AuthUser REST service loginUser();
- :white_large_square: Implement AuthUser REST service logoutUser();
- :white_large_square: Implement AuthUser REST service getDemoUser();
#### Homepage frontend 
- :white_large_square: Setup Vue Router;
- :white_large_square: Set up Vue RemoteServices;
- :white_large_square: Create HomepageView;
- :white_large_square: Route HomepageView;
- :white_large_square: Setup link from Homepage to other pages;
#### User authentication frontend (register and login)
- :white_large_square: Implement registerUser remote service;
- :white_large_square: Implement loginUser remote service;
- :white_large_square: Implement logoutUser remote service;
- :white_large_square: Create registerView;
- :white_large_square: Create loginView;
- :white_large_square: Route registerView;
- :white_large_square: Route loginView;
- :white_large_square: Create logout button in homepage;
#### User profile page frontend
- :white_large_square: Implement getUserById remote service;
- :white_large_square: Create userProfileView;
- :white_large_square: Route userProfileView;
#### Search page frontend
- :white_large_square: Implement getUsersByNameExpression remote service;
- :white_large_square: Create userSearchView;
- :white_large_square: Route userSearchView;
## Past Sprints
