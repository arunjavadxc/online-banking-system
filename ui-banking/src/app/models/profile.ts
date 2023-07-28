export class profile{
    accountNumber:number
    branch: String
    ifsc: number
    name: String
    balance: number
    emailId: String
    number: number
    address: String
    constructor(data:any){
        this.accountNumber = data.accountNumber
        this.branch = data.branch
        this.ifsc = data.ifsc
        this.name = data.name
        this.balance = data.balance
        this.emailId = data.emailId
        this.number = parseFloat(data.number)
        this.address = data.address
    }
}