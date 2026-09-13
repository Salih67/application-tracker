import './ApplicationCard.css'

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
        <article className="application-card">
            <header className="application-card-header">
                <h2>{company}</h2>
                <p>{position}</p>
            </header>
            <span className="application-card-status">{status}</span>
            <footer className="application-card-actions">
                <button onClick={() => onEdit(id)}>Edit</button>
                <button onClick={() => onDelete(id)}>Delete</button>
            </footer>
        </article>
    )
}

export default ApplicationCard