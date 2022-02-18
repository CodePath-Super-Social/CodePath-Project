Original App Design Project - README
===

# Super Social

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
An app that allows users to view their feeds from all social media accounts in one platform. For now, users can view Reddit and Twitter feeds. More social media platforms will be added later.  

### App Evaluation
- **Category:** Social Media
- **Mobile:** This app will be primarily developed for Android devices. 
- **Story:** Allow users to browse and post to multiple social media feeds from the comfort of one app without needing to switch between the respective apps.
- **Market:** Any individuals with Twitter and/or Reddit accounts can use the app. Benefits Influencers.
- **Habit:** The app can be used frequently depending on the user's activity on social media. Rather than switching back and forth between apps to be updated on the latest posts in each feed, the user can stay on this app to view all feeds at once.
- **Scope:** The app will initially support only Twitter and Reddit, with plans to add support for more social media feeds, such as Facebook and YouTube. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [ ] Users can log in to Reddit
* [ ] Users can log in to Twitter
* [ ] Users can view their Reddit feed
* [ ] Users can view their Twitter feed
* [ ] Feeds have infinite pagination
* [ ] Users can crosspost to selected social media feeds
    * [ ] Users can take photos with their camera for posts
* [ ] Users can pull-down to refresh feeds

**Optional Nice-to-have Stories**

* [ ] Users can interact with posts just like how they would in the native apps
* [ ] Users can choose which feeds they want displayed 
* [ ] Users can log in, view, and post their Facebook feed
* [ ] Users can log in, view, and watch videos from their YouTube feed

### 2. Screen Archetypes

* Feed
   * Users can view their Reddit feed
   * Users can view their Twitter feed
* Create Post
   * Users can create a post with a description and an optional photo
* Settings
   * Users can log in to Reddit
   * Users can log in to Twitter
   * (optional) Users can choose which feeds to be displayed

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Feed
* Create Post
* Settings

**Flow Navigation** (Screen to Screen)

* Feed
   * Feed item -> Detailed view
   * Reply button -> Create post
* Create post
   * Camera button -> Camera
* Settings
   * Login -> OAuth

## Wireframes
Refer to the Digital Wireframes below

### [BONUS] Digital Wireframes & Mockups
<img width="231" alt="Settings" src="https://user-images.githubusercontent.com/78000116/154627513-b038cfc2-8129-471c-98cc-35a66e5e1036.png"> |
<img width="234" alt="Feed" src="https://user-images.githubusercontent.com/78000116/154627545-f6684430-6647-4113-b47c-1bca22fab723.png">
<img width="232" alt="Create Post" src="https://user-images.githubusercontent.com/78000116/154627561-ea373b74-2dd4-4a1b-ac36-5499397c61e2.png">
<img width="233" alt="Detailed Twiiter Item" src="https://user-images.githubusercontent.com/78000116/154627568-867f844a-4bb1-4347-b84d-8c6ca4c625b2.png">
<img width="235" alt="Detailed Reddit Item" src="https://user-images.githubusercontent.com/78000116/154627573-80f1526e-340d-49d1-8eb1-35dc920bda3b.png">



### [BONUS] Interactive Prototype

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
