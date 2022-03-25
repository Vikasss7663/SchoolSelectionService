# Get Schools
curl http://localhost:9091/school
[{"schoolId":1,"schoolName":"Example Academy, Ex","emailTo":"example_to@gmail.com","emailBcc":"example_bcc@gmail.com","emailCc":"example_cc@gmail.com"}]

# Get School by ID
curl http://localhost:9091/school/{id}

# Add School
curl -d '{"schoolName":"Example Academy, Ex","emailTo":"example_to@gmail.com","emailBcc":"example_bcc@gmail.com","emailCc":"example_cc@gmail.com"}' -H "Content-Type: application/json" -X POST http://localhost:9091/school

# Update School
curl -d '{"schoolId":1, "schoolName":"Example Academy, Ex","emailTo":"example_to@gmail.com","emailBcc":"example_bcc@gmail.com","emailCc":"example_cc@gmail.com"}' -H "Content-Type: application/json" -X PUT http://localhost:9091/school

# Delete School
curl -X DELETE http://localhost:9091/school/{id}