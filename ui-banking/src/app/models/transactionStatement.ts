export class transactionStatement {
    amountWithdraw : number
    amountDeposit  : number
    balanceAmount  : number
    transactionMode : string
    description     : string
    transactionDate : Date
    constructor(data:any){
        this.amountWithdraw  = parseFloat(data.amountWithdraw)  
        this.amountDeposit   = parseFloat(data.amountDeposit)
        this.balanceAmount   = parseFloat(data.balanceAmount)  
        this.transactionMode = data.transactionMode
        this.description     = data.description    
        this.transactionDate = new Date(data.transactionDate)

    }
}
