setup:
install node node-v6.9.5-x64
install ruby rubyinstaller-2.3.3-x64
---------------- after software installed
Command line executions:
gem install compass
npm install -g yo bower grunt-cli
npm install -g generator-angular
------------------------
clone the git repo and from project path execute following commands:
bower install
npm install
grunt build 
grunt server 

#Enjoy from login page :-)
-------------------------------
(for compass missing)if any issues install execute>gem install compass (google) :-(

https://www.sitepoint.com/kickstart-your-angularjs-development-with-yeoman-grunt-and-bower/


# iot-client

This project is generated with [yo angular generator](https://github.com/yeoman/generator-angular)
version 0.15.1.

## Build & development

Run `grunt` for building and `grunt serve` for preview.

## Testing

Running `grunt test` will run the unit tests with karma.
