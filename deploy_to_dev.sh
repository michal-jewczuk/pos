#!/bin/bash

restPath='pos-rest/build/libs'
domainPath='pos-domain/build/libs'
jarPattern='SNAPSHOT\|RELEASE'

echo "Deplyoing to dev "

echo ">>> list jars from rest and domain"
ls $restPath | grep $jarPattern
ls $domainPath | grep $jarPattern
