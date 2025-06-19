Do I have authorization to view the pods?
    k auth can-i get pods 
    Optional: set verbosity level --v

How to access a pod?
    k exec -it pod-name -- /bin/bash

How to write to a file inside a pod?
   echo "Hello from inside the pod" > file.txt or
   k exec -it pod-name -- /bin/bash -c echo "Hello from inside the pod" > file.txt

