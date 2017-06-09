#!/bin/bash

mvn package
~/glassfish5/bin/asadmin deploy --force=true target/airline.war