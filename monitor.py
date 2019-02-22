#function to check if the portal is up and running or not. We're looking for http 200 status code here
#I put in timeout of 10 seconds in case the site is completely unreachable or down for the function to exit
def get_portal_response():
    try:
        portal_response = requests.get("http://172.16.10.10:8080/client",timeout=10)
        return portal_response

    except requests.exceptions.Timeout as errc:
        timeout_code = 504
        print("Time: 0.0,Status_Code: %d" %(timeout_code))
        sys.exit()

#Function to list templates
def get_templates():
    return cs.listTemplates(templatefilter="featured")

#variable to store returned status code
milcloud_portal_status = get_portal_response()
status_code = milcloud_portal_status.status_code

#Measure the response time by taking the average of 3 successful execution, this is done only if the portal is up
#otherwise register the status code only.
if milcloud_portal_status.status_code == requests.codes.ok :
    avg_time = timeit.timeit(get_templates,number=3)
    response_time = round(avg_time,2)
    print("Time: %.2f,Status_Code: %d" %(response_time,status_code))
else:
    print("Time: 0.0,Status_Code: %d" %(status_code))
