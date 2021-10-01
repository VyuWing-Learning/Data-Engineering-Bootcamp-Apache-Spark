# Data Engineering Hands On: Apache Spark

## Problem Description
Web Server logs contain information on any event that was registered/logged with the website. This data contains a lot of insights on **website visitors**, **behavior**, **crawlers accessing the site**, **business insights**, **security issues**, etc.

In this **Bootcamp**, we will learn to use **Apache Spark**  and extract useful insights from a sample **Web Server Log**.

## Downloading the Dataset
Download the sample **Web Server Log** dataset by clicking <a href="https://drive.google.com/file/d/1DwIFBu5PvxN7dqL34UA7uyDQAhrIPrbD/view? usp=sharing">here</a>.

## Project Setup:
To run this project in your local. Follow the below steps: 
1) Open it up in IntelliJ or any other IDE. (Download IntelliJ Community Version from <a href="https://www.jetbrains.com/idea/download/#section=linux"> here</a>)
2) Install Scala plugin by going into Settings. (For <a href="https://www.jetbrains.com/help/idea/discover-intellij-idea-for-scala.html">reference</a>)
<img src="https://resources.jetbrains.com/help/img/idea/2021.2/scala_plugin_page.png" width="500" />
3) Put the dataset in data directory. (data/access.log)<br />
4) run _mvn clean install_ on the terminal to download all dependencies and build the jar. IntelliJ users can ignore this step, as it automatically downloads the requisite dependancies and creates the build.

Once you run the main class it will read the data/access.log file and parse it using Apache Spark and write the output files in data/logdata/ directory in parquet file format. It will also print the hourly trend table data on the console.

## Interactively running the code in Scala shell
1) Setup the shell from run configuration.\
![alt text](https://i.ibb.co/SyQy2mC/Screenshot-2021-10-01-at-10-10-41-AM.png)\

2) Select scala REPL \
![alt text](https://i.ibb.co/GTz1bsN/Screenshot-2021-10-01-at-10-02-20-AM.png)\
![alt text](https://i.ibb.co/cL3m0pD/Screenshot-2021-10-01-at-10-01-42-AM.png)

3) Run the Scala REPL and execute the code by _CTRL + ALT + X_  for windows and _CONTROL + COMMAND + X_ for Mac users.

For reference please <a href="https://www.jetbrains.com/help/idea/run-debug-configuration-scala-console.html">visit</a>.

## FAQ's
### what is scala-shell?
This is an interactive way to run the scala code. It is similar to python shell where we interactively run python scripts.

### What is parquet file?
It is highly compressed columnar file format which is optimized for high speed reads and is prominently used in enterprise data warehouses.  Further reads about <a href="https://databricks.com/glossary/what-is-parquet">Apache Parquet.</a>


## You're all set. <a href="https://vyuwinglearning.com/">VyuWing</a> is Happy to Help!

For doubts on the project and to learn more, get in touch with our team : info@vyuwinglearning.com
