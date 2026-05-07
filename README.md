# PomoTask

1. Project Title: PomoTask
2. Authors: Jeremy Rafidimanana, Val Tlahuice, Anh Ngoc Nguyen
3. Project description

Our project is a task manager that provides the user different features such as playing white noise, using the Pomodoro studying method, and managing tasks.

- Technical guide:
It requires that you have Java 17/21 installed. It requires access to Macalester’s Kilt Graphics library,  java.awt.Color, javax.sound.sampled.*, and java.io.File 
The main class is called MainPage.java. To run the program, the user needs to run the main method within the main class.

- Credits:
The inspiration for the Pomodoro timer comes from pomofocus.io which defines the Pomodoro technique as a way of studying that breaks it up into intervals for work and breaks, long and short. The idea to create a tomato was inspired by Khan Academy’s html lesson on creating a tomato. The inspiration for the task manager came from Notion. The idea for the soundbar’s specific way of working came from imissmycafe.com. The source for the alarm beep sound comes from Freesound.org, specifically the creator Rudmer_Rotteveel.  
We got help from Pr. Paul Cantrell who gave us some insights about the use of KiltGraphics.
The used white noises are: CALMING RAIN by Liecio, Forest Nature by SoundReality, and Coffee Shop byTrainscough5407 (Freesound) on Pixabay: https://pixabay.com/ 

4. Known issues
The Pomodoro timer has an issue where if you have already started playing the timer, it won’t reset until you restart the timer which is an odd bug but isn’t detrimental to the program. The user is also currently unable to change the timer’s duration. 
The user is unable to add more than a certain number of tasks (number TBD) at a time since this number is constrained by the size of the canvas. Moreover, the tasks that the user wants to write cannot exceed a certain number of characters (number TBD) because GraphicsGroup and TextField don’t allow the programmers to change the size of the textfield. 
The volume changer only has three options of 50%, 100%, and 150% instead of having a volume bar with a knob that allows easier volume setting.

5. Societal impact
- Potential exclusion/harm to vulnerable populations
A blind person would be unable to visualize the way the task manager is displayed, as there is no Audio Description that could tell them what is going on on the screen. People with hearing disabilities would also be unable to hear the white noise. Someone who doesn’t speak English cannot understand the instructions from the buttons since our program doesn’t offer any alternative languages. People who would like to write down longer tasks in the text field would not find this program convenient since it only allows for tasks that can be written in a couple of characters. People who have more than x number of tasks may not find this program useful as they can only add a limited number of tasks to it.

- Malicious opportunities that may occur: 
Currently, there is no way to control the number of continuous working sessions or breaks, if the user does too many study sessions in a row, it could be exploited to encourage unhealthy work habits, burnout, or counterproductive behavior. 
Our program only has a single productivity style, which may disadvantage users with ADHD, anxiety, disabilities, or different working patterns.

- Unintended consequences: 
Someone with sensitivity to noise might be unintentionally hurt when the alarm goes off after the timer goes off. There is no current warning when the alarm beep sounds. And no current way to turn the alarm sound off or deafen it other than turning off the volume on your computer itself. The user might currently believe that their tasks are finished when they aren’t by mistakenly clicking check and not being able to uncheck. 



