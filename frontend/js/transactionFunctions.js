


// part 3
async function createTransaction(){
    // placeholders for actual names that need to be put in
    const amount = document.getElementById("price")
    const user = JSON.parse(localStorage.getItem("userId"))
    const productId = document.getElementById("productID");
    const transaction = {
        transactionId: 0,
        amount: amount.ariaValueMax,
        status: "pending",
        productId: productId.value,
        buyerId: user.userId
    }
    let config = {
        method:"POST",
        headers:{'Content-Type':'application/json'},
        body: JSON.stringify(body)
    };
    let url = ""
    const response = await fetch(url,config)
    if(response.status == 200){
        alert("Successfully bought")
    }
    else{
        alert("This transaction has failed please try again")
    }
}

function updateTransactionStatus(){
    const status = document.getElementById("status")
    const transactionId = document.getElementById("transactionId")
    const url = `/api/transactions/${transactionId.value}/${status.value}`
    const response = await fetch(url)
    if(response.status == 200){
        alert("Successful status update")
    }
    else{
        alert("Unsuccessful status update")
    }
}