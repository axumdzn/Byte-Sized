const messagetableBody = document.getElementById("tableBody");
const name = document.getElementById("name");
const touserid = document.getElementById("userid")
const textarea = document.getElementById("textarea")
const title = document.getElementById("title")
const userId = 2 //window.localStorage.getItem("userId");

async function requestSendingMessage() {
    let messageInfo = {
        "messageId": 0,
        "idFrom": userId,
        "idTo": touserid.value,
        "message": textarea.value,
        "title": title.value
    }

    let newRequest = {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(messageInfo)
    }
    console.log(newRequest)

    let getURL = "http://localhost:8080/messageSend"

    let response = await fetch(getURL, newRequest)
    console.log(getURL)
    if (response.status === 201) {

        alert("message sent successfully");
    } else if (response.status === 405) {
        let responseBody = await response.json()
        alert(responseBody.message);
    }
}



function currentMessageReqest(returnedInfo) {
    let indexId = 1

    for (let obj of returnedInfo) {
        const newRow = document.createElement("tr");
        messagetableBody.appendChild(newRow);
        let index = indexId;
        let idFrom = obj.idFrom;
        let nameFrom = obj.nameFrom;
        let title = obj.title;
        let message = obj.message;
        let date = obj.dateCreated;

        returnedInfoList = [index, idFrom, nameFrom, title, message, date];
        for (let elements of returnedInfoList) {
            const tData = document.createElement("td");
            tData.textContent = elements
            newRow.appendChild(tData)
        }
        indexId++
    }
}

async function MessageRequests() {
    let userId = 2
    let getURL = "http://127.0.0.1:8080/getmessagesbyid/" + userId

    let response = await fetch(getURL, { method: "GET" })

    if (response.status === 201) {
        let returnedInfo = await response.json();

        currentMessageReqest(returnedInfo);
    } else if (response.status === 405) {
        let responseBody = await response.json()
        alert(responseBody.message);
    }
}

MessageRequests();