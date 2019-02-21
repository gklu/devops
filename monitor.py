#!/usr/bin/env  python
import  requests
import datetime
import timeit
from cs import CloudStack
import sys
import os

#instantiate cloudstack endpoint with credential
cs = CloudStack(endpoint="http://172.16.10.10:8080/client/api",
                key="bCAkYMrYbKzu7fPYTPkPEVnxy9CJ_3ZlwBJOozCuHGLmxh3TGLYQL34F8X2cdj3aHqak-Tdo4wEXGqhGHDKzew",
                secret="Vy5R1liIC1wvBgtM73GEYdVbcnao5yjmPjLMduqGbCvUblhiYNh2-kWqM_wSNwayRg43TY8--b5FrJrMojddOw")

#Let's create timestamp in the format below
currDate = datetime.datetime.now()
currDate = str(currDate.strftime("%m-%d-%Y %H:%M:%S"))

#Check if data.txt file exists if not create new one with header
#data_file =  os.path.join(os.getcwd(),"data.txt")
#if not os.path.exists(data_file):
#    with open(data_file,'w') as file:
#        file.write('timestamp'+','+'response_time' +','+'status_code'+'\n')

#function to check if the portal is up and running or not. We're looking for http 200 status code here
#I put in timeout of 10 seconds in case the site is completely unreachable or down for the function to exit
def get_portal_response():
    try:
        portal_response = requests.get("http://172.16.10.10:8080/client",timeout=10)
        portal_response_status = portal_response.status_code
        return portal_response_status
    except requests.exceptions.ConnectionError as errc:
        print ("Error Connecting:",errc)
        sys.exit()

#Function to list templates
def get_templates():
    return cs.listTemplates(templatefilter="featured")

#variable to store returned status code
milcloud_portal_status = get_portal_response()

#Measure the response time by taking the average of 3 successful execution, this is done only if the portal is up
#otherwise register the status code only.
if milcloud_portal_status == 200 :
    avg_time = timeit.timeit(get_templates,number=3)*1000
    response_time = round(avg_time)
    #with open("data.txt","a+") as file:
    #    file.write(currDate + "," + response_time + "," + str(milcloud_portal_status) + '\n')

#else:
#    with open("data.txt","a+") as file:
#        file.write(currDate + "," + "0" + "," + str(milcloud_portal_status) + '\n')

print(float(response_time))


