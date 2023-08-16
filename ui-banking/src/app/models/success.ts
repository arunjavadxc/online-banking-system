export class success{
    numberOfMonth: Number
    totalAmount: Number
    interest: Number
    typeOfLoan: String
    emiamount: Number
    constructor(success:any){
        this.numberOfMonth=success.numberOfMonth
        this.totalAmount=success.totalAmount
        this.interest=success.interest
        this.typeOfLoan=success.typeOfLoan
        this.emiamount= success.emiamount
    }
}