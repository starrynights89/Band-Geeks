import { Inventory} from './inventory';
import { Student } from './student';
import { Instructor } from './instructor';
import { Status } from './status';

export class Request {
    requestId: number;
    inventory: Inventory;
    student: Student;
    instructor: Instructor;
    checkIn: Date;
    checkOut: Date;
    status: Status;
}
