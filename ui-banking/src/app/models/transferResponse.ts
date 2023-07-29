export class response{
    transactionAmount: number
    balance: number
    receiver: String
    constructor(response: any){
        this.transactionAmount = response.transactionAmount
        this.balance = response.balance
        this.receiver = response.receiver
    }
}