type ApplicationCardProps ={
    id: number;
    company: string;
    position: string;
    status: string
    onDelete: (id: number) => void
    onEdit: (id:number) => void
}

function ApplicationCard({id, company, position, status, onDelete, onEdit}: ApplicationCardProps) {
    return (
        <article>
            <button onClick={() => onEdit(id)}>Edit</button>
            <button onClick={() => onDelete(id)}>Delete</button>
            <h2>{company}</h2>
            <h2>{position}</h2>
            <h2>{status}</h2>
        </article>
    )
}

export default ApplicationCard